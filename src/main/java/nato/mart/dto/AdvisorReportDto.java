package nato.mart.dto;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Embeddable
public class AdvisorReportDto {
  // Max. allowed length for H2 is 1048576 characters.
  private static final int MAX_TEXT_LENGTH = 1048576;

  @Column(length = MAX_TEXT_LENGTH)
  private String recommendations;
  @Column(length = MAX_TEXT_LENGTH)
  private String comments;
  @Column(length = MAX_TEXT_LENGTH)
  private String attitude;
  @Column(length = MAX_TEXT_LENGTH)
  private String description;
  @ElementCollection
  private List<PersonDto> contacts;
  @ElementCollection
  private List<String> topics;
  private String eventHeadline;

  /**
   * Moment report was transmitted via SMTP
   */
  private Instant submittedTime;

  private String grid;
  private UUID location;
  private String municipality;
  private String reportingTeam;
  private String command;
  private UUID uuid;

  /**
   * Moment the last modification was done the the report.
   */
  private Instant lastModificationTime;

  /**
   * Date the event took place.
   */
  private Instant eventDate;

  /**
   * Date the event ended.
   */
  private Instant eventEndDate;

  private String sender;

  @ElementCollection
  private List<String> factors;
  @ElementCollection
  private List<String> domains;
  @ElementCollection
  private List<ImageDto> images;

  public AdvisorReportDto() {}

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getRecommendations() {
    return recommendations;
  }

  public void setRecommendations(String recommendations) {
    this.recommendations = recommendations;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getAttitude() {
    return attitude;
  }

  public void setAttitude(String attitude) {
    this.attitude = attitude;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<PersonDto> getContacts() {
    return contacts;
  }

  public void setContacts(List<PersonDto> contacts) {
    this.contacts = contacts;
  }

  public List<String> getTopics() {
    return topics;
  }

  public void setTopics(List<String> topics) {
    this.topics = topics;
  }

  public String getEventHeadline() {
    return eventHeadline;
  }

  public void setEventHeadline(String eventHeadline) {
    this.eventHeadline = eventHeadline;
  }

  public Instant getSubmittedTime() {
    return submittedTime;
  }

  public void setSubmittedTime(Instant submittedTime) {
    this.submittedTime = submittedTime;
  }

  public String getGrid() {
    return grid;
  }

  public void setGrid(String grid) {
    this.grid = grid;
  }

  public UUID getLocation() {
    return location;
  }

  public void setLocation(UUID location) {
    this.location = location;
  }

  public String getReportingTeam() {
    return reportingTeam;
  }

  public void setReportingTeam(String reportingTeam) {
    this.reportingTeam = reportingTeam;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public Instant getLastModificationTime() {
    return lastModificationTime;
  }

  public void setLastModificationTime(Instant lastModificationTime) {
    this.lastModificationTime = lastModificationTime;
  }

  public List<String> getFactors() {
    return factors;
  }

  public void setFactors(List<String> factors) {
    this.factors = factors;
  }

  public List<String> getDomains() {
    return domains;
  }

  public void setDomains(List<String> domains) {
    this.domains = domains;
  }

  public List<ImageDto> getImages() {
    return images;
  }

  public void setImages(List<ImageDto> images) {
    this.images = images;
  }

  public String getMunicipality() {
    return municipality;
  }

  public void setMunicipality(String municipality) {
    this.municipality = municipality;
  }

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public Instant getEventDate() {
    return eventDate;
  }

  public void setEventDate(Instant eventDate) {
    this.eventDate = eventDate;
  }

  public Instant getEventEndDate() {
    return eventEndDate;
  }

  public void setEventEndDate(Instant eventEndDate) {
    this.eventEndDate = eventEndDate;
  }
}
