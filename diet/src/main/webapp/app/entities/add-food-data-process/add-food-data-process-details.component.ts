import { Component, Vue, Inject } from 'vue-property-decorator';

import { IAddFoodDataProcess } from '@/shared/model/add-food-data-process.model';
import AddFoodDataProcessService from './add-food-data-process.service';

@Component
export default class AddFoodDataProcessDetailsComponent extends Vue {
  @Inject('addFoodDataProcessService') private addFoodDataProcessService: () => AddFoodDataProcessService;
  public addFoodDataProcess: IAddFoodDataProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveAddFoodDataProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveAddFoodDataProcess(addFoodDataProcessId) {
    this.isFetching = true;
    this.addFoodDataProcessService()
      .find(addFoodDataProcessId)
      .then(
        res => {
          this.addFoodDataProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
