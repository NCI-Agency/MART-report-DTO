package nato.mart.dto;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class ImageDto {
  private String fileName;
  @Lob
  private byte[] data;
  private String title;
  private String mimeType;

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }
}
