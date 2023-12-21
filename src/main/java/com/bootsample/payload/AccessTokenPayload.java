package com.bootsample.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class AccessTokenPayload {
    
    @Schema(name = "AccessTokenPayload.Request")
    @Getter
    @Setter
    public static class Request{
        
        @NotNull
		@Schema(description = "userName", example = "demo-client")
        private String userName;
        @NotNull
        @Schema(description = "passWord", example = "secret")
        private String passWord;

    }
    
    @Schema(name = "AccessTokenPayload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "accessToken", example = "eyJraWQiOiI3YjM5ZWIyYi01NmRmLTRhNzctYWMwNi1hOTQ0Y2Q4NjVkYzMiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJkZW1vLWNsaWVudCIsImF1ZCI6ImRlbW8tY2xpZW50IiwibmJmIjoxNjg4NjIzMTQ3LCJzY29wZSI6WyJvcGVuaWQiXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo5MDAwIiwiZXhwIjoxNjg4NjI0MDQ3LCJpYXQiOjE2ODg2MjMxNDd9.T4KkpeyTfl3BknJP_favDgAz6g2URFPNiOyZhgFkSHPjj09feY6HcsCiLQ4uCF1d9rdCkcBa9uK-_aATLGzF4EWBp6NeWU0sd9MIOmao7pyfg-vO6hlZE_-hHy4ptFeuofmFRNDtHYUhkUjtlgmYuzzEHGn6XzSzrNvzHzEoOzyCyMZRO0X2ZmAjNtla76TdxwpNGa5lEbTZiymMFenFHSrrUqu_WICUAXJBxZ05cJRfqVQVrGVNXeo7Pkoc15tXeSVon57-Sk2ke_x0qXmIO6l6CsjttjGp9JeBTqvZT-28qS8HPRhF4hfzkEM7aF1yNIzT-ahtmsZF25Nav8N2ug")
        @JsonProperty("access_token")
        private String accessToken;
        
        @Schema(description = "scope", example = "openid")
        private String scope;

        @Schema(description = "tokenType", example = "Bearer")
        @JsonProperty("token_type")
        private String tokenType;

        @Schema(description = "expiresIn", example = "900")
        @JsonProperty("expires_in")
        private String expiresIn;
    }
}
