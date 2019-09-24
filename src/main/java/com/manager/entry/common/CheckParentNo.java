package com.manager.entry.common;

/**
 * 校验上下级关系
 */
public interface CheckParentNo {

    String getSuperPNo();

    void setSuperPNo(String superPNo);

    String getSuperPLevel();

    void setSuperPLevel(String superPLevel);

    String getSysNo();

    void setSysNo(String sysNo);

    String getSuperParent();

    void setSuperParent(String superParent);
}
