package springboot_project.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import springboot_project.test.model.Punonjes;

public class ControllerTest extends springboot_project.test.Test {

        @Override
        @Before
        public void setUp() {
            super.setUp();
        }

        @Test
        public void getPunonjesList() throws Exception {
            String uri = "/punonjes";
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                    .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            Punonjes[] punonjeslist = super.mapFromJson(content, Punonjes[].class);
            assertTrue(punonjeslist.length > 0);
        }

        @Test
        public void createPunonjes() throws Exception {
            String uri = "/punonjes";
            Punonjes punonjes = new Punonjes();
            punonjes.setIdPunonjes("3");
            punonjes.setName("Test");
            punonjes.setGender("Test");
            punonjes.setEmail("Test");
            punonjes.setAddress("Test");
            String inputJson = super.mapToJson(punonjes);
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(inputJson)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            assertEquals(201, status);
            String content = mvcResult.getResponse().getContentAsString();
            assertEquals(content, "Punonjes is created successfully");
        }

        @Test
        public void updatePunonjes() throws Exception {
            String uri = "/punonjes/2";
            Punonjes punonjes = new Punonjes();
            punonjes.setName("TestUpdate");
            String inputJson = super.mapToJson(punonjes);
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(inputJson)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            assertEquals(content, "Punonjes is updated successsfully");
        }

        @Test
        public void deletePunonjes() throws Exception {
            String uri = "/punonjes/2";
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            assertEquals(content, "Punonjes is deleted successsfully");
        }

}
