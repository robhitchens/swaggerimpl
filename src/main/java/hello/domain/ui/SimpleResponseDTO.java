package hello.domain.ui;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DifferentSimpleResponseDTO", description = "Not quite sure how to use the @ApiModel annotation.", subTypes = {DummyDTO.class})
public class SimpleResponseDTO {
    private int code;
    private String message;

    @ApiModelProperty(value = "Http code stored in response dto", allowableValues = "100,101,200,201,202,203,204,205,206,300,301,302,303,304,305,306,307,400,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,500,501,502,503,504,505")
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @ApiModelProperty(value = "Message stored in response dto")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
