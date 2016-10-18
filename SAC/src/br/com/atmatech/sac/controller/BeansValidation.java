/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.controller;

import br.com.atmatech.sac.beans.UsuarioBeans;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Marcos
 */
public class BeansValidation {

    public Boolean isUsuario(UsuarioBeans ub) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<UsuarioBeans>> violations = validator.validate(ub);
        if (!violations.isEmpty()) {
            for (ConstraintViolation violation : violations) {
                validationMenssage(violation.getMessage());
                return false;
            }
        }
        return true;
    }

    private void validationMenssage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
