package br.ufrj.diet.web.rest;

import br.ufrj.diet.service.StoreUserDataProcessService;
import br.ufrj.diet.service.dto.StoreUserDataProcessDTO;
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
 * REST controller for managing {@link br.ufrj.diet.domain.StoreUserDataProcess}.
 */
@RestController
@RequestMapping("/api")
public class StoreUserDataProcessResource {

    private final Logger log = LoggerFactory.getLogger(StoreUserDataProcessResource.class);

    private static final String ENTITY_NAME = "storeUserDataProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StoreUserDataProcessService storeUserDataProcessService;

    public StoreUserDataProcessResource(StoreUserDataProcessService storeUserDataProcessService) {
        this.storeUserDataProcessService = storeUserDataProcessService;
    }

    /**
     * {@code POST  /store-user-data-processes} : Create a new storeUserDataProcess.
     *
     * @param storeUserDataProcessDTO the storeUserDataProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new storeUserDataProcessDTO, or with status {@code 400 (Bad Request)} if the storeUserDataProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/store-user-data-processes")
    public ResponseEntity<StoreUserDataProcessDTO> create(@RequestBody StoreUserDataProcessDTO storeUserDataProcessDTO)
        throws URISyntaxException {
        log.debug("REST request to save StoreUserDataProcess : {}", storeUserDataProcessDTO);
        if (storeUserDataProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new storeUserDataProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StoreUserDataProcessDTO result = storeUserDataProcessService.create(storeUserDataProcessDTO);
        return ResponseEntity
            .created(new URI("/api/store-user-data-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /store-user-data-processes} : get all the storeUserDataProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of storeUserDataProcesss in body.
     */
    @GetMapping("/store-user-data-processes")
    public List<StoreUserDataProcessDTO> getAllStoreUserDataProcesss() {
        log.debug("REST request to get all StoreUserDataProcesss");
        return storeUserDataProcessService.findAll();
    }

    /**
     * {@code GET  /store-user-data-processes/:id} : get the "id" storeUserDataProcess.
     *
     * @param processInstanceId the id of the storeUserDataProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the storeUserDataProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/store-user-data-processes/{processInstanceId}")
    public ResponseEntity<StoreUserDataProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get StoreUserDataProcess by processInstanceId : {}", processInstanceId);
        Optional<StoreUserDataProcessDTO> storeUserDataProcessDTO = storeUserDataProcessService.findByProcessInstanceId(processInstanceId);
        return ResponseUtil.wrapOrNotFound(storeUserDataProcessDTO);
    }
}
