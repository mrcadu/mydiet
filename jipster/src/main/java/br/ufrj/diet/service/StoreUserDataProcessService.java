package br.ufrj.diet.service;

import br.ufrj.diet.domain.StoreUserDataProcess;
import br.ufrj.diet.repository.StoreUserDataProcessRepository;
import br.ufrj.diet.repository.UserDietRepository;
import br.ufrj.diet.service.dto.StoreUserDataProcessDTO;
import br.ufrj.diet.service.mapper.StoreUserDataProcessMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link StoreUserDataProcess}.
 */
@Service
@Transactional
public class StoreUserDataProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "StoreUserDataProcess";

    private final Logger log = LoggerFactory.getLogger(StoreUserDataProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final UserDietRepository userDietRepository;

    private final StoreUserDataProcessRepository storeUserDataProcessRepository;

    private final StoreUserDataProcessMapper storeUserDataProcessMapper;

    public StoreUserDataProcessService(
        ProcessInstanceService processInstanceService,
        UserDietRepository userDietRepository,
        StoreUserDataProcessRepository storeUserDataProcessRepository,
        StoreUserDataProcessMapper storeUserDataProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.userDietRepository = userDietRepository;
        this.storeUserDataProcessRepository = storeUserDataProcessRepository;
        this.storeUserDataProcessMapper = storeUserDataProcessMapper;
    }

    /**
     * Save a storeUserDataProcess.
     *
     * @param storeUserDataProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public StoreUserDataProcessDTO create(StoreUserDataProcessDTO storeUserDataProcessDTO) {
        log.debug("Request to save StoreUserDataProcess : {}", storeUserDataProcessDTO);

        StoreUserDataProcess storeUserDataProcess = storeUserDataProcessMapper.toEntity(storeUserDataProcessDTO);

        //Saving the domainEntity
        userDietRepository.save(storeUserDataProcess.getUserDiet());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "UserDiet#" + storeUserDataProcess.getUserDiet().getId(),
            storeUserDataProcess
        );
        storeUserDataProcess.setProcessInstance(processInstance);

        //Saving the process entity
        storeUserDataProcess = storeUserDataProcessRepository.save(storeUserDataProcess);
        return storeUserDataProcessMapper.toDto(storeUserDataProcess);
    }

    /**
     * Get all the storeUserDataProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<StoreUserDataProcessDTO> findAll() {
        log.debug("Request to get all StoreUserDataProcesss");
        return storeUserDataProcessRepository
            .findAll()
            .stream()
            .map(storeUserDataProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one storeUserDataProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<StoreUserDataProcessDTO> findOne(Long id) {
        log.debug("Request to get StoreUserDataProcess : {}", id);
        return storeUserDataProcessRepository.findById(id).map(storeUserDataProcessMapper::toDto);
    }

    /**
     * Get one storeUserDataProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<StoreUserDataProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get StoreUserDataProcess by  processInstanceId: {}", processInstanceId);
        return storeUserDataProcessRepository.findByProcessInstanceId(processInstanceId).map(storeUserDataProcessMapper::toDto);
    }
}
