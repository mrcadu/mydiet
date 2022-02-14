/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import DietDetailComponent from '@/entities/diet/diet-details.vue';
import DietClass from '@/entities/diet/diet-details.component';
import DietService from '@/entities/diet/diet.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Diet Management Detail Component', () => {
    let wrapper: Wrapper<DietClass>;
    let comp: DietClass;
    let dietServiceStub: SinonStubbedInstance<DietService>;

    beforeEach(() => {
      dietServiceStub = sinon.createStubInstance<DietService>(DietService);

      wrapper = shallowMount<DietClass>(DietDetailComponent, { store, localVue, router, provide: { dietService: () => dietServiceStub } });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundDiet = { id: 123 };
        dietServiceStub.find.resolves(foundDiet);

        // WHEN
        comp.retrieveDiet(123);
        await comp.$nextTick();

        // THEN
        expect(comp.diet).toBe(foundDiet);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundDiet = { id: 123 };
        dietServiceStub.find.resolves(foundDiet);

        // WHEN
        comp.beforeRouteEnter({ params: { dietId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.diet).toBe(foundDiet);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
