package Builder;

import java.util.List;

enum Sex {
    MALE,

    FEMALE
}

public class User {
    private String mName;

    private int mAge;

    private Sex mSex;

    private String mAddress;

    private boolean mIsMarried;

    private float mHeight;

    private float mWeight;

    public User(String name, int age, Sex sex, String address, boolean isMarried,
        float height, float weight) {
        mName = name;
        mAge = age;
        mSex = sex;
        mAddress = address;
        mIsMarried = isMarried;
        mHeight = height;
        mWeight = weight;
    }

    public User(Builder builder) {
        mName = builder.mBuilderName;
        mAge = builder.mBuilderAge;
        mSex = builder.mBuilderSex;
        mIsMarried = builder.mBuilderIsMarried;
        mHeight = builder.mBuilderHeight;
        mWeight = builder.mBuilderWeight;
    }

    public static class Builder {
        String mBuilderName;

        int mBuilderAge;

        Sex mBuilderSex;

        String mBuilderAddress;

        boolean mBuilderIsMarried;

        float mBuilderHeight;

        float mBuilderWeight;

        public Builder withName(String name) {
            mBuilderName = name;
            return this;
        }

        public Builder withAge(int age) {
            mBuilderAge = age;
            return this;
        }

        public Builder withSex(Sex sex) {
            mBuilderSex = sex;
            return this;
        }

        public Builder withAddress(String address) {
            mBuilderAddress = address;
            return this;
        }

        public Builder withIsMarried(boolean isMarried) {
            mBuilderIsMarried = isMarried;
            return this;
        }

        public Builder withHeight(float height) {
            mBuilderHeight = height;
            return this;
        }

        public Builder withWeight(float weight) {
            mBuilderWeight = weight;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {
        // 普通的初始化, 这里无法分辨出最后两个参数分别对应height还是weight
        User userRegular = new User("John", 22, Sex.MALE, "Shanghai", false, 175, 175);

        // Builder初始化, 可以很方便看明白每一个参数的含义
        User userBuilder = new User.Builder().withName("John")
            .withAge(22)
            .withSex(Sex.MALE)
            .withAddress("Shanghgai")
            .withIsMarried(false)
            .withHeight(175)
            .withWeight(175)
            .build();
    }
}
