package cristinapalmisani.BEU2W2P2.controller;

import cristinapalmisani.BEU2W2P2.entities.Device;
import cristinapalmisani.BEU2W2P2.exception.BadRequestException;
import cristinapalmisani.BEU2W2P2.payloads.device.DeviceRequestDTO;
import cristinapalmisani.BEU2W2P2.payloads.device.DeviceResponseDTO;
import cristinapalmisani.BEU2W2P2.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public Page<Device> getDevices(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "5") int size,
                                   @RequestParam(defaultValue = "id") String orderBy){
        return deviceService.getDevices(page, size, orderBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceResponseDTO createdDevice(@RequestBody @Validated DeviceRequestDTO body, BindingResult validation){
        if (validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return new DeviceResponseDTO(body.userId());
        }

    }
}
