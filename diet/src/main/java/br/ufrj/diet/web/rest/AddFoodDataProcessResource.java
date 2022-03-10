package br.ufrj.diet.web.rest;

import br.ufrj.diet.service.AddFoodDataProcessService;
import br.ufrj.diet.service.dto.AddFoodDataProcessDTO;
import br.ufrj.diet.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link br.ufrj.diet.domain.AddFoodDataProcess}.
 */
@RestController
@RequestMapping("/api")
public class AddFoodDataProcessResource {

    private final Logger log = LoggerFactory.getLogger(AddFoodDataProcessResource.class);

    private static final String ENTITY_NAME = "addFoodDataProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AddFoodDataProcessService addFoodDataProcessService;

    public AddFoodDataProcessResource(AddFoodDataProcessService addFoodDataProcessService) {
        this.addFoodDataProcessService = addFoodDataProcessService;
    }

    /**
     * {@code POST  /add-food-data-processes} : Create a new addFoodDataProcess.
     *
     * @param addFoodDataProcessDTO the addFoodDataProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new addFoodDataProcessDTO, or with status {@code 400 (Bad Request)} if the addFoodDataProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/add-food-data-processes")
    public ResponseEntity<AddFoodDataProcessDTO> create(@RequestBody AddFoodDataProcessDTO addFoodDataProcessDTO)
        throws URISyntaxException {
        log.debug("REST request to save AddFoodDataProcess : {}", addFoodDataProcessDTO);
        if (addFoodDataProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new addFoodDataProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AddFoodDataProcessDTO result = addFoodDataProcessService.create(addFoodDataProcessDTO);
        return ResponseEntity
            .created(new URI("/api/add-food-data-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /add-food-data-processes} : get all the addFoodDataProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of addFoodDataProcesss in body.
     */
    @GetMapping("/add-food-data-processes")
    public List<AddFoodDataProcessDTO> getAllAddFoodDataProcesss() {
        log.debug("REST request to get all AddFoodDataProcesss");
        return addFoodDataProcessService.findAll();
    }

    /**
     * {@code GET  /add-food-data-processes/:id} : get the "id" addFoodDataProcess.
     *
     * @param processInstanceId the id of the addFoodDataProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the addFoodDataProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/add-food-data-processes/{processInstanceId}")
    public ResponseEntity<AddFoodDataProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get AddFoodDataProcess by processInstanceId : {}", processInstanceId);
        Optional<AddFoodDataProcessDTO> addFoodDataProcessDTO = addFoodDataProcessService.findByProcessInstanceId(processInstanceId);
        return ResponseUtil.wrapOrNotFound(addFoodDataProcessDTO);
    }
}
