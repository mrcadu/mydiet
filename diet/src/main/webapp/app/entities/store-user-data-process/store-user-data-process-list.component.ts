import { Component, Vue, Inject } from 'vue-property-decorator';
import { IStoreUserDataProcess } from '@/shared/model/store-user-data-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import StoreUserDataProcessService from './store-user-data-process.service';

@Component
export default class StoreUserDataProcessListComponent extends Vue {
  @Inject('storeUserDataProcessService') private storeUserDataProcessService: () => StoreUserDataProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'StoreUserDataProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public storeUserDataProcessList: IStoreUserDataProcess[] = [];

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
    this.storeUserDataProcessService()
      .retrieve()
      .then(
        res => {
          this.storeUserDataProcessList = res.data;
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
