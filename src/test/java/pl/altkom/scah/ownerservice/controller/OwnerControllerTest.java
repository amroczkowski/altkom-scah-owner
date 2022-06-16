package pl.altkom.scah.ownerservice.controller;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import pl.altkom.scah.ownerservice.controller.model.CreateOwnerRequest;
import pl.altkom.scah.ownerservice.controller.model.Owner;
import pl.altkom.scah.ownerservice.controller.model.UpdateOwnerRequest;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@AutoConfigureMockMvc
class OwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSingleOwnerAndHttpStatusOk() throws Exception {

        //given

        //when
        final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/owner/50"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        //then
        final Owner owner = jsonToObject(mvcResult.getResponse().getContentAsString());
        Assertions.assertThat(owner.getId()).isEqualTo(50L);
        Assertions.assertThat(owner.getFirstName()).isEqualTo("Lysandra");
        Assertions.assertThat(owner.getLastName()).isEqualTo("Miles");
    }

    @Order(1)
    @Test
    void shouldReturnAllOwnersAndHttpStatusOk() throws Exception {

        //given

        //when
        final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/owner"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        //then
        final List<Owner> owners = jsonToListOfObjects(mvcResult.getResponse().getContentAsString());
        Assertions.assertThat(owners).isNotEmpty();
        Assertions.assertThat(owners.size()).isEqualTo(1000);
    }

    @Test
    void shouldReturnHttpStatusNotFound() throws Exception {
        //given

        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/owner/11150"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
        //then
    }

    @Test
    void shouldCreateAndSaveOwnerAndReturnStatusOk() throws Exception {

        //given
        final String requuest = objectToJson(new CreateOwnerRequest("Lysandra", "Miles", "48123123123"));

        //when
        final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/owner")
                .content(requuest)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        //then
        final Owner owner = jsonToObject(mvcResult.getResponse().getContentAsString());
        Assertions.assertThat(owner.getFirstName()).isEqualTo("Lysandra");
        Assertions.assertThat(owner.getLastName()).isEqualTo("Miles");
    }

    @Test
    void shouldUpdateOwnerAndReturnStatusOk() throws Exception {

        //given
        final String requuest = objectToJson(new UpdateOwnerRequest("Lysandra", "Miles", "48123123123"));

        //when
        final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/owner/1")
                .content(requuest)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        //then
        final Owner owner = jsonToObject(mvcResult.getResponse().getContentAsString());
        Assertions.assertThat(owner.getId()).isEqualTo(1L);
        Assertions.assertThat(owner.getFirstName()).isEqualTo("Lysandra");
        Assertions.assertThat(owner.getLastName()).isEqualTo("Miles");
    }

    private String objectToJson(final Object obj) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writeValueAsString(obj);
    }

    private Owner jsonToObject(final String json) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(json, Owner.class);
    }

    private List<Owner> jsonToListOfObjects(final String json) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(json, new TypeReference<List<Owner>>() {
        });
    }
}