import { Component, Vue, Inject } from 'vue-property-decorator';

import { IStoreUserDataProcess, StoreUserDataProcess } from '@/shared/model/store-user-data-process.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { UserDiet } from '@/shared/model/user-diet.model';
import StoreUserDataProcessService from './store-user-data-process.service';

const validations: any = {
  storeUserDataProcess: {
    userDiet: {
      username: {},
      password: {},
      age: {},
      genre: {},
      biotype: {},
      goal: {},
      weight: {},
      height: {},
      neck: {},
      waist: {},
      hip: {},
      bodyFat: {},
    },
  },
};

@Component({
  validations,
})
export default class StoreUserDataStartFormInitComponent extends Vue {
  @Inject('storeUserDataProcessService') private storeUserDataProcessService: () => StoreUserDataProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'StoreUserDataProcess';
  public storeUserDataProcess: IStoreUserDataProcess = new StoreUserDataProcess();

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initStoreUserDataStartForm();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;

    this.storeUserDataProcessService()
      .create(this.storeUserDataProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('dietApp.storeUserDataStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initStoreUserDataStartForm(): void {
    this.storeUserDataProcess.userDiet = new UserDiet();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.storeUserDataProcess.processInstance = new ProcessInstance();
      this.storeUserDataProcess.processInstance.processDefinition = res;
    });
  }
}
