package framework.functor;

import framework.IParty;

public interface IFunctor<T> {
    
    public void updateBalance(T t);
    
}
