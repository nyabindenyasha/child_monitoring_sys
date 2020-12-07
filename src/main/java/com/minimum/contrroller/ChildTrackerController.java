package com.minimum.contrroller;

import com.minimum.local.ActionResult;
import com.minimum.local.PharmacyRequest;
import com.minimum.local.VehicleResponse;
import com.minimum.model.ChildTracker;
import com.minimum.service.ChildTrackerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/childmonitor")
public class ChildTrackerController {

    @Autowired
    ChildTrackerService childTrackerService;

    @ApiOperation(value = "", response = Iterable.class)
    @PostMapping()
    public ResponseEntity<ActionResult> save(@Valid @RequestBody ChildTracker kombiTracker) {
        ActionResult result = new ActionResult();
        try {
            kombiTracker.setTime(new Date());
            childTrackerService.save(kombiTracker);
            result.setMessage("Success");
            return ResponseEntity.ok().body(result);
        } catch (Exception exception) {
            result.setMessage(exception.getMessage());
            return new ResponseEntity<ActionResult>(result, HttpStatus.BAD_GATEWAY);
        }
    }


    @ApiOperation(value = "", response = Iterable.class)
    @PostMapping("/pharmacy")
    public ResponseEntity<ActionResult> save(@Valid @RequestBody PharmacyRequest pharmacyRequest) {
        ActionResult result = new ActionResult();
        result.setMessage("success");
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/querry")
    public ResponseEntity<ActionResult> saveUsingQuerry(@RequestParam("childId") int childId,
                                                        @RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude) {
        ActionResult result = new ActionResult();
        try {
            ChildTracker childTracker = new ChildTracker();
            LocalDateTime ldt = convertToLocalDateTime(new Date()).plusHours(2);
            Date date = convertToDateViaInstant(ldt);
            childTracker.setTime(date);
            childTracker.setCurrentLocationLatitude(latitude);
            childTracker.setCurrentLocationLongitude(longitude);
            childTracker.setChildId(childId);
            childTrackerService.save(childTracker);
            result.setMessage("Success");
            return ResponseEntity.ok().body(result);
        } catch (Exception exception) {
            result.setMessage(exception.getMessage());
            return new ResponseEntity<ActionResult>(result, HttpStatus.BAD_GATEWAY);
        }
    }

    @ApiOperation(value = "", response = Iterable.class)
    @GetMapping()
    public ResponseEntity<Iterable<VehicleResponse>> findAll() {
        try {
            Iterable<ChildTracker> rfidEkombiKombiTrackerList = childTrackerService.findAll();
            List<VehicleResponse> vehicleResponseView = new ArrayList<>();

            for (ChildTracker childTrackerTemp : rfidEkombiKombiTrackerList) {
                VehicleResponse vehicleResponse = new VehicleResponse();
                vehicleResponse.setId(childTrackerTemp.getId());
                vehicleResponse.setCurrentLocationLatitude(childTrackerTemp.getCurrentLocationLatitude());
                vehicleResponse.setCurrentLocationLongitude(childTrackerTemp.getCurrentLocationLongitude());
                vehicleResponse.setTime(childTrackerTemp.getTime().toString());
                vehicleResponse.setChildId(childTrackerTemp.getChildId());
                vehicleResponseView.add(vehicleResponse);
            }

            return ResponseEntity.ok().body(vehicleResponseView);
        } catch (Exception exception) {
            Iterable<VehicleResponse> iterable = null;
            return new ResponseEntity<Iterable<VehicleResponse>>(iterable, HttpStatus.BAD_GATEWAY);
        }
    }

    @ApiOperation(value = "", response = Iterable.class)
    @GetMapping("find/allRecordsByChildId/{childId}")
    public ResponseEntity<Iterable<VehicleResponse>> findRecordsByVehicleId(@PathVariable int childId) {
        try {
            Iterable<ChildTracker> rfidEkombiKombiTrackerList = childTrackerService.findAll();
            List<VehicleResponse> vehicleResponseView = new ArrayList<>();
            List<ChildTracker> vehiclesWithvehicleId = new ArrayList<>();

            for (ChildTracker x : rfidEkombiKombiTrackerList) {
                if (x.getChildId() == childId)
                    vehiclesWithvehicleId.add(x);
            }

            for (ChildTracker childTrackerTemp : vehiclesWithvehicleId) {
                VehicleResponse vehicleResponse = new VehicleResponse();
                vehicleResponse.setId(childTrackerTemp.getId());
                vehicleResponse.setCurrentLocationLatitude(childTrackerTemp.getCurrentLocationLatitude());
                vehicleResponse.setCurrentLocationLongitude(childTrackerTemp.getCurrentLocationLongitude());
                vehicleResponse.setTime(childTrackerTemp.getTime().toString());
                vehicleResponse.setChildId(childTrackerTemp.getChildId());
                vehicleResponseView.add(vehicleResponse);
            }

            return ResponseEntity.ok().body(vehicleResponseView);
        } catch (Exception exception) {
            Iterable<VehicleResponse> iterable = null;
            return new ResponseEntity<Iterable<VehicleResponse>>(iterable, HttpStatus.BAD_GATEWAY);
        }
    }

    @ApiOperation(value = "", response = Iterable.class)
    @GetMapping("findOneRecordByChildId/{childId}")
    public ResponseEntity<VehicleResponse> findRecordByVehicleId(@PathVariable int childId) {
        try {
            Iterable<ChildTracker> rfidEkombiKombiTrackerList = childTrackerService.findAll();
            List<VehicleResponse> vehicleResponseView = new ArrayList<>();
            List<ChildTracker> vehiclesWithvehicleId = new ArrayList<>();

            for (ChildTracker x : rfidEkombiKombiTrackerList) {
                if (x.getChildId() == childId)
                    vehiclesWithvehicleId.add(x);
            }

            if (vehiclesWithvehicleId.size() == 0)
                return ResponseEntity.notFound().build();

            ChildTracker childTrackerTemp = vehiclesWithvehicleId.get(vehiclesWithvehicleId.size() - 1);

            VehicleResponse vehicleResponse = new VehicleResponse();
            vehicleResponse.setId(childTrackerTemp.getId());
            vehicleResponse.setCurrentLocationLatitude(childTrackerTemp.getCurrentLocationLatitude());
            vehicleResponse.setCurrentLocationLongitude(childTrackerTemp.getCurrentLocationLongitude());
            vehicleResponse.setTime(childTrackerTemp.getTime().toString());
            vehicleResponse.setChildId(childTrackerTemp.getChildId());


            return ResponseEntity.ok().body(vehicleResponse);
        } catch (Exception exception) {
            Iterable<VehicleResponse> iterable = null;
            return new ResponseEntity<VehicleResponse>(HttpStatus.BAD_GATEWAY);
        }
    }

    @ApiOperation(value = "", response = Iterable.class)
    @GetMapping("{id}")
    public ResponseEntity<Optional<ChildTracker>> findOne(@PathVariable int id) {
        Optional<ChildTracker> kombiTracker = childTrackerService.findOne(id);
        if (!kombiTracker.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(kombiTracker);
    }

    @ApiOperation(value = "", response = Iterable.class)
    @DeleteMapping("{id}")
    public ResponseEntity<ActionResult> delete(@PathVariable int id) {
        ActionResult result = new ActionResult();
        if (childTrackerService.findOne(id) != null) {
            childTrackerService.delete(id);
            result.setMessage("Success");
            return ResponseEntity.ok().body(result);
        }
        result.setMessage("Cannot delete the ChildTracker");
        return new ResponseEntity<ActionResult>(result, HttpStatus.BAD_REQUEST);
    }

    Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

    LocalDateTime convertToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}
