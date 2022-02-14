/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import FoodComponent from '@/entities/food/food.vue';
import FoodClass from '@/entities/food/food.component';
import FoodService from '@/entities/food/food.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('Food Management Component', () => {
    let wrapper: Wrapper<FoodClass>;
    let comp: FoodClass;
    let foodServiceStub: SinonStubbedInstance<FoodService>;

    beforeEach(() => {
      foodServiceStub = sinon.createStubInstance<FoodService>(FoodService);
      foodServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<FoodClass>(FoodComponent, {
        store,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          foodService: () => foodServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      foodServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllFoods();
      await comp.$nextTick();

      // THEN
      expect(foodServiceStub.retrieve.called).toBeTruthy();
      expect(comp.foods[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
