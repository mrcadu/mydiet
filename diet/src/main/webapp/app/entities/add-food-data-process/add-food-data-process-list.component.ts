import { Component, Vue, Inject } from 'vue-property-decorator';
import { IAddFoodDataProcess } from '@/shared/model/add-food-data-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import AddFoodDataProcessService from './add-food-data-process.service';

@Component
export default class AddFoodDataProcessListComponent extends Vue {
  @Inject('addFoodDataProcessService') private addFoodDataProcessService: () => AddFoodDataProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'AddFoodDataProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public addFoodDataProcessList: IAddFoodDataProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.addFoodDataProcessService()
      .retrieve()
      .then(
        res => {
          this.addFoodDataProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
