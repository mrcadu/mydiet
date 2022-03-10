import { Component, Vue, Inject } from 'vue-property-decorator';

import { IAddFoodDataProcess, AddFoodDataProcess } from '@/shared/model/add-food-data-process.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { Food } from '@/shared/model/food.model';
import AddFoodDataProcessService from './add-food-data-process.service';

const validations: any = {
  addFoodDataProcess: {
    food: {
      name: {},
      username: {},
      grams: {},
      protein: {},
      carbohydrate: {},
      fat: {},
      calories: {},
    },
  },
};

@Component({
  validations,
})
export default class AddFoodDataStartFormInitComponent extends Vue {
  @Inject('addFoodDataProcessService') private addFoodDataProcessService: () => AddFoodDataProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'AddFoodDataProcess';
  public addFoodDataProcess: IAddFoodDataProcess = new AddFoodDataProcess();

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initAddFoodDataStartForm();
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

    this.addFoodDataProcessService()
      .create(this.addFoodDataProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('dietApp.addFoodDataStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initAddFoodDataStartForm(): void {
    this.addFoodDataProcess.food = new Food();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.addFoodDataProcess.processInstance = new ProcessInstance();
      this.addFoodDataProcess.processInstance.processDefinition = res;
    });
  }
}
