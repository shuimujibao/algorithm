package designpatterns.structure.bridge.bag;

import designpatterns.structure.bridge.material.Material;

public abstract class BagAbstraction {
    protected Material material;

    public void setMaterial(Material material) {
        this.material = material;
    }

    public abstract void pick();
}
