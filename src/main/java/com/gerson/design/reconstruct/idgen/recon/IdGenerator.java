package com.gerson.design.reconstruct.idgen.recon;

import com.gerson.design.exception.IdGenerationFailureException;

/**
 * @author gezz
 * @description
 * @date 2020/5/6.
 */
public interface IdGenerator {
    String generate() throws IdGenerationFailureException;
}
