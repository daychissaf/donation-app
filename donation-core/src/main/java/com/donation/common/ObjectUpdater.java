package com.donation.common;

import java.lang.reflect.InvocationTargetException;

public interface ObjectUpdater {
    void update(Object objectToUpdate, Object newObjectData) throws InvocationTargetException, IllegalAccessException;
}
