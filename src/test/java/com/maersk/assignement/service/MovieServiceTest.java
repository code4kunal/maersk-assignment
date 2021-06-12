package com.maersk.assignement.service;

import com.maersk.assignement.persistence.dao.MovieDAO;
import com.maersk.assignement.persistence.entity.MovieEntity;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
class MovieServiceTest {

    @Mock
    private MovieDAO movieDAO;

    @Mock
    private MovieEntity shoppingCartEntity;

    @MockBean
    private MovieService movieService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    //@Test
//    public void createProduct_validProductName_createdSuccessfully(){
//        NewMovie newNewMovie = NewMovie.builder()
//                .type(ProductType.MOBILE.toString())
//                .quantity(5)
//                .perUnitPrice(BigDecimal.valueOf(15250)).build();
//       MovieEntity expected =
//               MovieEntity.builder().productId(Long.valueOf(1)).
//                       price(BigDecimal.valueOf(15250))
//                       .type(ProductType.MOBILE).quantity(5).build();
//
//       Mockito.when(movieDAO.save(any())).thenReturn(expected);
//       shoppingCartService.createProduct(newNewMovie);
//       Assert.assertEquals(ProductType.MOBILE, expected.getType());
//    }
//
//    @Test
//    public void createProduct_invalidOrEmptyProductType_throwException(){
//
//        NewMovie newNewMovie = NewMovie.builder()
//                .type(null)
//                .quantity(5)
//                .perUnitPrice(BigDecimal.valueOf(15250)).build();
//        exceptionRule.expect(ShoppingCartApplicationException.class);
//        shoppingCartService.createProduct(newNewMovie);
//    }
//
//    @Test
//    public void createProduct_invalidOrEmptyQuantity_throwException(){
//        NewMovie newNewMovie = NewMovie.builder()
//                .type(ProductType.MOBILE.toString())
//                .quantity(-1)
//                .perUnitPrice(BigDecimal.valueOf(15250)).build();
//        exceptionRule.expect(ShoppingCartApplicationException.class);
//        shoppingCartService.createProduct(newNewMovie);
//    }
//
//    @Test
//    public void createProduct_invalidOrEmptyPrice_throwException(){
//        NewMovie newNewMovie = NewMovie.builder()
//                .type(ProductType.MOBILE.toString())
//                .quantity(1)
//                .perUnitPrice(BigDecimal.valueOf(-222)).build();
//        exceptionRule.expect(ShoppingCartApplicationException.class);
//        shoppingCartService.createProduct(newNewMovie);
//
//    }
//
//
}