package com.cassio.studies.behavior.decorator;

/**
 * Base abstraction class for the all juice decorators. Wrap a juice object and
 * decorate a specific description and price.
 * 
 * @author Cassio
 */
public abstract class JuiceDecorator extends Juice {

    @Override
    public abstract Float price();
}
