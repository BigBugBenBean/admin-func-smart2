package com.pccw.immd.adminfunc.service;

import com.pccw.immd.adminfunc.dto.UpmsUser;
import ws.upms.immd.v1.ITIAppException;
import ws.upms.immd.v1.ITISysException;

public interface UpmsService {

    UpmsUser login(String userId, String password, String terminalId) throws ITIAppException, ITISysException;

    void changePassword(String userId, String password, String newPassword) throws ITIAppException, ITISysException;

    void logout(String userId) throws ITIAppException, ITISysException;

}
