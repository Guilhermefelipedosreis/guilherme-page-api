package messages.register.api.messages;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MessageRegisterDTO(

                @NotBlank @Size(max = 200, message = "{validation.name.size.too_long}") String name,

                @NotBlank @Email @Size(max = 200, message = "{validation.email.size.too_long}") String email,

                @Size(max = 25, message = "{validation.phone.size.too_long}") String phone,

                @NotBlank @Size(max = 200, message = "{validation.content.size.too_long}") String content) {
}
