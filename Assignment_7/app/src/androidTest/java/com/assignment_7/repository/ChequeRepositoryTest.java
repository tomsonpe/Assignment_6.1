package com.assignment_7.repository;

import android.test.AndroidTestCase;

import com.assignment_7.domain.Cheque;
import com.assignment_7.repositories.repository.ChequeRepository;
import com.assignment_7.repositories.repositoryImplem.ChequeRepositoryImplem;

import junit.framework.Assert;

import java.sql.SQLException;
import java.util.Set;

/**
 *Created by Phinda Encore Tomson on 4/21/2016.
 */
public class ChequeRepositoryTest extends AndroidTestCase {
    private static final String TAG="CASH TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        ChequeRepository chequeRepo=new ChequeRepositoryImplem(this.getContext());
        Cheque createEntity=new Cheque.Builder()
                .no("50000")
                .name("Encore")
                .build();

        Cheque insertedEntity=chequeRepo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        Set<Cheque> cheque=chequeRepo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", cheque.size() > 0);

        Cheque entity=chequeRepo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY ", entity);

        Cheque updateEntity=new Cheque.Builder()
                .copy(entity)
                .name("Encore")
                .build();
        chequeRepo.update(updateEntity);
        Cheque newEntity=chequeRepo.findById(id);
        Assert.assertEquals(TAG+" UPDATE ENTITY","ENCORE",newEntity.getName());

        chequeRepo.delete(updateEntity);
        Cheque deletedEntity=chequeRepo.findById(id);
        Assert.assertNull(TAG+" DELETE ",deletedEntity);
    }
}
