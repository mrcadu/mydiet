/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import DietComponent from '@/entities/diet/diet.vue';
import DietClass from '@/entities/diet/diet.component';
import DietService from '@/entities/diet/diet.service';

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
  describe('Diet Management Component', () => {
    let wrapper: Wrapper<DietClass>;
    let comp: DietClass;
    let dietServiceStub: SinonStubbedInstance<DietService>;

    beforeEach(() => {
      dietServiceStub = sinon.createStubInstance<DietService>(DietService);
      dietServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<DietClass>(DietComponent, {
        store,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          dietService: () => dietServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      dietServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllDiets();
      await comp.$nextTick();

      // THEN
      expect(dietServiceStub.retrieve.called).toBeTruthy();
      expect(comp.diets[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
