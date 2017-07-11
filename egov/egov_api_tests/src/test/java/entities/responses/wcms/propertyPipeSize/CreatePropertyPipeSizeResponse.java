package entities.responses.wcms.propertyPipeSize;

import entities.responses.wcms.ResponseInfo;
import org.codehaus.jackson.annotate.JsonProperty;

public class CreatePropertyPipeSizeResponse {
    @JsonProperty("ResponseInfo")
    private ResponseInfo ResponseInfo;
    @JsonProperty("PropertyPipeSize")
    private PropertyPipeSize[] PropertyPipeSize;

    public ResponseInfo getResponseInfo() {
        return this.ResponseInfo;
    }

    public void setResponseInfo(ResponseInfo ResponseInfo) {
        this.ResponseInfo = ResponseInfo;
    }

    public PropertyPipeSize[] getPropertyPipeSize() {
        return this.PropertyPipeSize;
    }

    public void setPropertyPipeSize(PropertyPipeSize[] PropertyPipeSize) {
        this.PropertyPipeSize = PropertyPipeSize;
    }
}