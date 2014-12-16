package com.cassio.studies.behavior.decorator;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing behaviors after wrap (decorate) the object.   
 *  
 * @author ecasdia
 */
public class JuiceDecoratorTest {

    private Juice juice;
    
    @Before
    public void setup(){
	juice = new OrangeJuice();
    }
    
    @Test
    public void given_orangejuice_test_name_and_price() {
	assertThat("Opps, should be Orange Juice", juice.description, is("Orange juice"));
	assertThat("Opps, Orange Juice should cost 1 EUR", juice.price(), is(1.0F));
    }
    
    @Test
    public void given_sugar_to_orange_juice_test_price_is_same() {
	juice = new SugarDecorator(juice);
	assertThat("Opps, Orange Juice should cost 1 EUR", juice.price(), is(1.0F));
    }
    
    @Test
    public void given_sugar_to_orange_juice_test_description_changed() {
	juice = new SugarDecorator(juice);
	assertThat("Opps, Orange Juice description should change", juice.getDescription(), is("Orange juice with Sugar"));
    }

    @Test
    public void given_sugar_and_peppermint_test_description_and_price_changed() {
	juice = new SugarDecorator(juice);
	juice = new PeppermintDecorator(juice);
	assertThat("Opps, Orange Juice description should change", juice.getDescription(), is("Orange juice with Sugar with peppermint"));
	assertThat("Opps, Orange with sugar and peppermint should cost 1.05 EUR", juice.price(), is(1.05F));
    }
    
    @Test
    public void given_peppermint_andstrawberry_test_description_and_price_changed() {
	juice = new PeppermintDecorator(juice);
	juice = new StrawberryDecorator(juice);
	assertThat("Opps, Orange Juice description should change", juice.getDescription(), is("Orange juice with peppermint with strawberry"));
	assertThat("Opps, Orange with sugar and peppermint should cost 1.05 EUR", juice.price(), is(2.05F));
    }
}
