package mx.nopaloverflow.petservices.api;

import mx.nopaloverflow.petservices.api.requests.CompanyRegistrationRequest;
import mx.nopaloverflow.petservices.api.requests.LoginRequest;
import mx.nopaloverflow.petservices.dtos.SessionDto;
import mx.nopaloverflow.petservices.dtos.UserDto;
import mx.nopaloverflow.petservices.exceptions.EntityAlreadyRegisteredException;
import mx.nopaloverflow.petservices.facades.companies.CompanyRegistrationFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/companies/**")
public class CompaniesController {
    private static final Logger LOG = LoggerFactory.getLogger(CompaniesController.class);

    @Resource(name = "companyRegistrationFacade")
    private CompanyRegistrationFacade companyRegistrationFacade;

    @PostMapping
    public ResponseEntity<UserDto> registerCompany(@RequestBody final CompanyRegistrationRequest request)
            throws EntityAlreadyRegisteredException {
        LOG.trace("Trying to register a new pet company");

        final var dto =
                companyRegistrationFacade.registerCompany(request);

        LOG.trace("Registered a the new company");

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{companyId}/enable")
    @ResponseStatus(HttpStatus.OK)
    public void enableCompany(@PathVariable final String companyId) {
        companyRegistrationFacade.enableCompany(companyId);
    }

    @PostMapping("/authentication")
    public SessionDto authenticate(@RequestBody final LoginRequest request) {
        return null;
    }
}
