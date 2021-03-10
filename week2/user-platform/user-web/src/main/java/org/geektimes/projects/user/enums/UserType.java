package org.geektimes.projects.user.enums;

/**
 * @author hxhowl
 * @since 2021/3/9
 */
public enum UserType {// 底层实际 public final class UserType extends java.lang.Enum

    NORMAL,
    VIP;

    UserType(){ // 枚举中构造器是 private

    }

    public static void main(String[] args) {
        UserType.VIP.ordinal();
    }
}
