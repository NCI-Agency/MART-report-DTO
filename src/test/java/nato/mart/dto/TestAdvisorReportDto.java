package nato.mart.dto;

import static org.assertj.core.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Base64;
import java.util.UUID;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class TestAdvisorReportDto {

  @Test
  public void testReportDeserialization() throws IOException, URISyntaxException {

    String json = this.readTextResource("sample-report.json");

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());

    AdvisorReportDto advisorReport = objectMapper.readValue(json, AdvisorReportDto.class);

    assertThat(advisorReport.getUuid()).as("Advisor Report DTO, GUID")
        .isEqualTo(UUID.fromString("a23679a0-17bf-4901-ab60-81a4a706e7f7"));
    assertThat(advisorReport.getLastModificationTime())
        .as("Advisor Report DTO, property: lastModificationTime")
        .isEqualTo(Instant.parse("2021-04-20T10:30:00.000Z"));
    assertThat(advisorReport.getSubmittedTime()).as("Advisor Report DTO, property: submittedTime")
        .isEqualTo(Instant.parse("2021-04-20T13:50:00Z"));
    assertThat(advisorReport.getEventDate()).as("Advisor Report DTO, property: eventDate")
        .isEqualTo(Instant.parse("2021-04-19T15:00:00Z"));
    assertThat(advisorReport.getEventEndDate()).as("Advisor Report DTO, property: eventEndDate")
        .isEqualTo(Instant.parse("2021-04-19T16:00:00Z"));

    assertThat(advisorReport.getReportingTeam()).as("Advisor Report DTO, property: reportingTeam")
        .isEqualTo("W5");
    assertThat(advisorReport.getCommand()).as("Advisor Report DTO, property: createdAt")
        .isEqualTo("RMLT");
    assertThat(advisorReport.getDescription()).as("Advisor Report DTO, property: description")
        .isEqualTo("Description information filled");
    assertThat(advisorReport.getComments()).as("Advisor Report DTO, property: comments")
        .isEqualTo("LMT Comments information filled");
    assertThat(advisorReport.getAttitude()).as("Advisor Report DTO, property: attitude")
        .isEqualTo("Attitude/Behavior of the Contact information filled");

    assertThat(advisorReport.getContacts())
        .as("Advisor Report DTO, property: contacts, number of contacts").hasSize(1);
    final PersonDto contact = advisorReport.getContacts().get(0);
    assertThat(contact.getFirstName()).as("PersonDto, property: firstName").isEqualTo("Častimir");
    assertThat(contact.getLastName()).as("PersonDto, property: lastName").isEqualTo("Kralj");
    assertThat(contact.getNationality()).as("PersonDto, property: nationality")
        .isEqualTo("Slovenia");
    assertThat(contact.getPosition()).as("PersonDto, property: position").isEqualTo("student");
    assertThat(contact.getOrganisation()).as("PersonDto, property: organisation")
        .isEqualTo("University of Ljubljana");

    assertThat(advisorReport.getFactors()).as("Advisor Report DTO, property: factors")
        .containsExactly("Weak institutions");

    assertThat(advisorReport.getGrid()).as("Advisor Report DTO, property: grid")
        .isEqualTo("4QFJ12345678");

    assertThat(advisorReport.getLocation().toString()).as("Advisor Report DTO, property: location")
        .isEqualToIgnoringCase("48CB5D86-E2CF-45A7-A24A-CA2219E18BA4"); // Zvecan
    assertThat(advisorReport.getMunicipality()).as("Advisor Report DTO, property: municipality")
        .isEqualTo("Mun 1");

    assertThat(advisorReport.getSender()).as("Advisor Report DTO, property: sender")
        .isEqualTo(null);

    assertThat(advisorReport.getImages()).as("Advisor Report DTO, property: images").hasSize(1);
    final ImageDto image = advisorReport.getImages().get(0);
    assertThat(image.getFileName()).as("ImageDto, property: fileName").isEqualTo("sample.png");
    assertThat(image.getData()).as("ImageDto, property: data")
        .isEqualTo(Base64.getDecoder()
            .decode("iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAA5FBMVEUAAAD/AAD/AID/AFW/AEDM"
                + "AGbVAFXbAEnfAGDjAFXMAE3RAEbbAEndAETdAFXPAFDXDVHZDU3cDFHZCVXbCVLTCU/aCFPXB1HZ"
                + "BlPYBlPWBVLYBVPVCU/WCVLZCVHVCE/YCFLWCFPXB1DWB1PXB0/WBlDWBlLYBlDWCFLXCFDYB1DW"
                + "B1HYB1HXB1HYB1HWBlDXBlLYBlHXCFLXCFHXB1LWB1LXB1LWBlHXBlHXCFDXCFHXB1HXB1LXB1DX"
                + "B1HWB1HWCFHXB1HXB1HXB1HXB1HXCFHXCFHXB1HXB1HXB1HXB1H///8h38pqAAAASnRSTlMAAQID"
                + "BAUGBwgJCgsODw8QExQWGxwdIiYoLjI0Nzg8PUFERkpNUFFWXWZpa25ydXZ6e4aHk5aZnZ6lqrGy"
                + "u73Dyc3R0uPt7vD5/XXIwbAAAACUSURBVHjaXMEDdgRBAEDBP7Zj20bHWfP+B9o3RhU5e9NQqWn3"
                + "k+Vy+nkpkQuG84/DjROx+JJJqd+jfVJ3yztSpyMX2EqQ+s8Ayu85cLWzrvP0QmqswPEaaFy/k+oB"
                + "txpIPJ6R+gMOLog050clNdDAe72Kz0RC5u0B8M9v9iRy2zOTNnFNm/W/R5sjzunYXU1BAMoCALb7"
                + "DZj/nhkQAAAAAElFTkSuQmCC"));
    assertThat(image.getTitle()).as("ImageDto, property: title").isEqualTo("Title of image");
    assertThat(image.getMimeType()).as("ImageDto, property: mimeType").isEqualTo("image/png");

    assertThat(advisorReport.getDomains()).as("Advisor Report DTO, property: domains").hasSize(0);
  }

  public String readTextResource(String name) throws URISyntaxException {
    URL url = getClass().getResource(name);
    if (url != null) {
      return readLineByLineJava8(Paths.get(url.toURI()), StandardCharsets.UTF_8);
    }
    return null;
  }

  private static String readLineByLineJava8(Path filePath, Charset encoding) {
    StringBuilder contentBuilder = new StringBuilder();

    try (Stream<String> stream = Files.lines(filePath, encoding)) {
      stream.forEach(s -> contentBuilder.append(s).append("\n"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return contentBuilder.toString();
  }
}
