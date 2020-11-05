package designpatterns.structure.adapter;

import designpatterns.product.bag.AppleBag;
import designpatterns.product.bag.OrangeBag;

public class OrangeBagAdapter extends OrangeBag {
    private AppleBag appleBag;

    public OrangeBagAdapter(AppleBag appleBag) {
        this.appleBag = appleBag;
    }

    @Override
    public void pack() {
        appleBag.pack();
    }
}
