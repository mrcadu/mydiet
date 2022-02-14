/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import MealComponent from '@/entities/meal/meal.vue';
import MealClass from '@/entities/meal/meal.component';
import MealService from '@/entities/meal/meal.service';

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
  describe('Meal Management Component', () => {
    let wrapper: Wrapper<MealClass>;
    let comp: MealClass;
    let mealServiceStub: SinonStubbedInstance<MealService>;

    beforeEach(() => {
      mealServiceStub = sinon.createStubInstance<MealService>(MealService);
      mealServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<MealClass>(MealComponent, {
        store,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          mealService: () => mealServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      mealServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllMeals();
      await comp.$nextTick();

      // THEN
      expect(mealServiceStub.retrieve.called).toBeTruthy();
      expect(comp.meals[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
