package com.pccw.immd.adminfunc.web.controller;

import com.pccw.immd.adminfunc.dto.PasswordDTO;
import com.pccw.immd.adminfunc.service.UpmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ws.upms.immd.v1.ITIAppException;
import ws.upms.immd.v1.ITISysException;


@Controller
public class ChangePasswordController {

    final String ALPHABET_REGEX = ".*[A-Za-z].*";
    final String NUMERIC_REGEX = ".*[0-9].*";

    public enum CHANGE_PWD_STATUS {
        CHANGE_PWD_SUCCESS,
        OLD_PWD_EMPTY,
        NEW_PWD_EMPTY,
        CONFIRM_NEW_PWD_EMPTY,
        AT_LEAST_6_CHARACTERS,
        PWD_SHOULD_CONTAIN_NUM_AND_ALPHABET,
        NEW_PWD_NOT_SAME_AS_CONFIRM_NEW_PWD,
        NEW_PWD_SAME_AS_OLD_PWD,
        OLD_PWD_INCORRECT
    }

    private static final Logger LOG = LoggerFactory.getLogger(ChangePasswordController.class);

    @Autowired
    @Qualifier("upmsService")
    private UpmsService upmsService;

    @RequestMapping(value = "/changePassword.do", method = RequestMethod.GET)
    public String changePwdPage() {
        return "/Auth/change-pwd";
    }

     @PostMapping("/submitChangePassword.do")
     public String submit(@ModelAttribute PasswordDTO passwordDTO) {
         LOG.info("Calling submitChangePassword ....... ");

         String loginId = passwordDTO.getLoginId();
         String oldPassword = passwordDTO.getOldPassword();
         String newPassword = passwordDTO.getNewPassword();
         String confirmNewPassword = passwordDTO.getConfirmNewPassword();

         LOG.info("loginId: " + loginId);
         LOG.info("oldPassword: " + oldPassword + " , newPassword: " + newPassword + " , confirmNewPassword: " + confirmNewPassword );

         CHANGE_PWD_STATUS status = validateChangePassword(oldPassword, newPassword, confirmNewPassword);

         Integer errCode = passwordDTO.getErrorCode();
         String errMsg = "";

         switch (status) {
             case CHANGE_PWD_SUCCESS: {
                break;
             }
             case OLD_PWD_EMPTY: {
                 errCode = 1001;
                 errMsg = "Please input Old Password.";
                 break;
             }
             case NEW_PWD_EMPTY: {
                 errCode = 1001;
                 errMsg = "Please input New Password.";
                 break;
             }
             case CONFIRM_NEW_PWD_EMPTY: {
                 errCode = 1001;
                 errMsg = "Please input Confirm New Password.";
                 break;
             }
             case AT_LEAST_6_CHARACTERS: {
                 errCode = 1001;
                 errMsg = "The new password should contain at least 6 characters";
                 break;
             }
             case PWD_SHOULD_CONTAIN_NUM_AND_ALPHABET: {
                 errCode = 1001;
                 errMsg = "The new password should contain both numeral and alphabet.";
                 break;
             }
             case NEW_PWD_NOT_SAME_AS_CONFIRM_NEW_PWD: {
                 errCode = 1001;
                 errMsg = "Thew new passwords are not the same.";
                 break;
             }
             case NEW_PWD_SAME_AS_OLD_PWD: {
                 errCode = 1001;
                 errMsg = "The new password should not be same as your last password.";
                 break;
             }
             case OLD_PWD_INCORRECT: {
                 errCode = 1002;
                 errMsg = "Your password cannot be updated due to the following reason: \n\n";
                 break;
             }
             default: {
                 break;
             }
         }

         LOG.info("errCode: " + errCode);

         passwordDTO.setErrorCode(errCode);
         passwordDTO.setErrorMessage(errMsg);



         if (errCode == -1) {
             // success

             try {
                 upmsService.changePassword(loginId, oldPassword, newPassword);
                 return "/auth/login-form";
             } catch (ITIAppException | ITISysException e) {
//                 String tmpErrMsg = "Your password cannot be updated due to the following reason:";
                 String tmpErrTitle = "Change Password Request";
                 passwordDTO.setErrorTitle(tmpErrTitle);
                 passwordDTO.setErrorMessage(e.getMessage());

                return "/auth/change-pwd-fail";
             }


         } else if (errCode == 1001) {

             return "/auth/change-pwd";
         } else if (errCode == 1002) {
             return "/auth/change-pwd-fail";
         }
         return "/Auth/change-pwd";
     }


     private CHANGE_PWD_STATUS validateChangePassword(String oldPwd, String newPwd, String confirmNewPwd) {

        // old password empty
        if (oldPwd.equals("")) {
            return CHANGE_PWD_STATUS.OLD_PWD_EMPTY;
        }

        // new password empty
        if (newPwd.equals("")) {
            return CHANGE_PWD_STATUS.NEW_PWD_EMPTY;
        }

        // confirm new password empty
        if (confirmNewPwd.equals("")) {
            return CHANGE_PWD_STATUS.CONFIRM_NEW_PWD_EMPTY;
        }

        // new password not same as confirm new password
        if (!newPwd.equals(confirmNewPwd)) {
            return CHANGE_PWD_STATUS.NEW_PWD_NOT_SAME_AS_CONFIRM_NEW_PWD;
        }

        // at least 6 characters
        if (newPwd.length() < 6) {
            return CHANGE_PWD_STATUS.AT_LEAST_6_CHARACTERS;
        }

        // new password same as old password
        if (oldPwd.equals(newPwd)) {
            return CHANGE_PWD_STATUS.NEW_PWD_SAME_AS_OLD_PWD;
        }

        // should contain numeric and alphabet
//        String keyword = newPwd;
//        String regex = "^[a-zA-Z0-9]*$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(keyword);
//        if (!matcher.find()) {
//            return CHANGE_PWD_STATUS.PWD_SHOULD_CONTAIN_NUM_AND_ALPHABET;
//        }
//        if (!isAlphaAndNumeric(newPwd)) {
//            return CHANGE_PWD_STATUS.PWD_SHOULD_CONTAIN_NUM_AND_ALPHABET;
//        }
         boolean isAlpha = isAlphabet(newPwd);
         boolean isNum = isNumeric(newPwd);

         if (!(isAlpha && isNum)) {
             return CHANGE_PWD_STATUS.PWD_SHOULD_CONTAIN_NUM_AND_ALPHABET;
         }

//         return CHANGE_PWD_STATUS.NEW_PWD_SAME_AS_OLD_PWD;
//        return CHANGE_PWD_STATUS.OLD_PWD_INCORRECT;
        return CHANGE_PWD_STATUS.CHANGE_PWD_SUCCESS;
     }

     private boolean isAlphabet(String keyword) {
//        String regex = ".*[A-Za-z].*";

        boolean isMatch = keyword.matches(ALPHABET_REGEX);
        LOG.info("isAlpha keyword: " + keyword + " , isMatch: " + isMatch);
        return isMatch;
     }

    private boolean isNumeric(String keyword) {
//        String regex = ".*[0-9].*";

        boolean isMatch = keyword.matches(NUMERIC_REGEX);
        LOG.info("isNumeric keyword: " + keyword + " , isMatch: " + isMatch);
        return isMatch;
    }

}
