package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {

    private static Map<String, Resume> map = new HashMap<>();

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void doSave(Resume resume, Object uuid) {
        map.put((String) uuid, resume);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey((String) searchKey);
    }

    @Override
    public Resume doGet(Object searchKey) {
        return map.get((String) searchKey);
    }

    @Override
    public void doDelete(Object searchKey) {
        map.remove((String) searchKey);
    }

    @Override
    public void doUpdate(Resume resume, Object searchKey) {
        map.put((String) searchKey, resume);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

}
