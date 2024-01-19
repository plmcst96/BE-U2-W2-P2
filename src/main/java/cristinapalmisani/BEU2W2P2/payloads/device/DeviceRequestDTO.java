package cristinapalmisani.BEU2W2P2.payloads.device;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record DeviceRequestDTO(
        @NotEmpty(message = "This items cannot be empty")
        @Size(max = 10, min = 4, message = "Type Device must be between 4 or 10 chars")
        String typeDevice,
        @NotEmpty
        @Size(max = 10, min = 4, message = "State must be between 4 or 10 chars")
        String state,
        @NotNull(message = "The user Id cannot be null")
        UUID userId) {
}
