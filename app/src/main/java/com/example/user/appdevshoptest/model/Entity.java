package com.example.user.appdevshoptest.model;


public class Entity {

    private Item item;
    private SubItem subItem;
    private boolean isCheck;


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public SubItem getSubItem() {
        return subItem;
    }

    public void setSubItem(SubItem subItem) {
        this.subItem = subItem;
    }

    public static Builder newBuilder() {
        return new Entity().new Builder();
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }


    public class Builder {

        private Builder() {
        }

        public Builder setItem(Item item) {
            Entity.this.item = item;

            return this;
        }

        public Builder setSubItem(SubItem subItem) {
            Entity.this.subItem = subItem;

            return this;
        }

        public Entity build() {
            return Entity.this;
        }

    }
}
