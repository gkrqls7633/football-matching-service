//package com.mateam.sample;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//@SpringBootTest
//public class SampleTestController {
//
////    @Autowired
////    private SampleController sampleController;
//
////    @Test
////    @DisplayName("1. home() 테스트")
////    void homeTest() throws Exception {
////        sampleController.home();
////        assertThat(sampleController.home()).isEqualTo("hello");
////    }
//
//    @Test
//    void shodHaveNoResulesInitially() throws Exception {
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
//
//        assertEquals(0, businessRuleEngine.count());
//    }
//
//    @Test
//    void shoudAddTwoActions() {
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
//
////        businessRuleEngine.addAction(() -> {});
////        businessRuleEngine.addAction(() -> {});
//
//        assertEquals(2, businessRuleEngine.count());
//    }
//
//    @Test
//    void shouldExecuteOneAction() throws Exception {
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
//        final Action mockAction = mock(Action.class);
//        final Facts mockFacts = mock(Facts.class);
//
//        final Customer customer = new Customer("Mark", "CEO");
//
//        businessRuleEngine.addAction(new Action() {
//            @Override
//            public void perform(Facts facts) {
//                if ("CEO".equals(customer.getJobTitle())) {
//                    Mailer.sendEmail("sales@Company.com", "Relevant customer : " + customer);
//                }
//            }
//        });
//
//        businessRuleEngine.addAction(mockAction);
//        businessRuleEngine.run();
//
//        verify(mockAction).perform(mockFacts);
//
//
//    }
//}
