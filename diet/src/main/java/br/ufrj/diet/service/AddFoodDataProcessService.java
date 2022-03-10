package br.ufrj.diet.service;

import br.ufrj.diet.domain.AddFoodDataProcess;
import br.ufrj.diet.repository.AddFoodDataProcessRepository;
import br.ufrj.diet.repository.FoodRepository;
import br.ufrj.diet.service.dto.AddFoodDataProcessDTO;
import br.ufrj.diet.service.mapper.AddFoodDataProcessMapper;
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
 * Service Implementation for managing {@link AddFoodDataProcess}.
 */
@Service
@Transactional
public class AddFoodDataProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "AddFoodDataProcess";

    private final Logger log = LoggerFactory.getLogger(AddFoodDataProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final FoodRepository foodRepository;

    private final AddFoodDataProcessRepository addFoodDataProcessRepository;

    private final AddFoodDataProcessMapper addFoodDataProcessMapper;

    public AddFoodDataProcessService(
        ProcessInstanceService processInstanceService,
        FoodRepository foodRepository,
        AddFoodDataProcessRepository addFoodDataProcessRepository,
        AddFoodDataProcessMapper addFoodDataProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.foodRepository = foodRepository;
        this.addFoodDataProcessRepository = addFoodDataProcessRepository;
        this.addFoodDataProcessMapper = addFoodDataProcessMapper;
    }

    /**
     * Save a addFoodDataProcess.
     *
     * @param addFoodDataProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public AddFoodDataProcessDTO create(AddFoodDataProcessDTO addFoodDataProcessDTO) {
        log.debug("Request to save AddFoodDataProcess : {}", addFoodDataProcessDTO);

        AddFoodDataProcess addFoodDataProcess = addFoodDataProcessMapper.toEntity(addFoodDataProcessDTO);

        //Saving the domainEntity
        foodRepository.save(addFoodDataProcess.getFood());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "Food#" + addFoodDataProcess.getFood().getId(),
            addFoodDataProcess
        );
        addFoodDataProcess.setProcessInstance(processInstance);

        //Saving the process entity
        addFoodDataProcess = addFoodDataProcessRepository.save(addFoodDataProcess);
        return addFoodDataProcessMapper.toDto(addFoodDataProcess);
    }

    /**
     * Get all the addFoodDataProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<AddFoodDataProcessDTO> findAll() {
        log.debug("Request to get all AddFoodDataProcesss");
        return addFoodDataProcessRepository
            .findAll()
            .stream()
            .map(addFoodDataProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one addFoodDataProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AddFoodDataProcessDTO> findOne(Long id) {
        log.debug("Request to get AddFoodDataProcess : {}", id);
        return addFoodDataProcessRepository.findById(id).map(addFoodDataProcessMapper::toDto);
    }

    /**
     * Get one addFoodDataProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AddFoodDataProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get AddFoodDataProcess by  processInstanceId: {}", processInstanceId);
        return addFoodDataProcessRepository.findByProcessInstanceId(processInstanceId).map(addFoodDataProcessMapper::toDto);
    }
}
