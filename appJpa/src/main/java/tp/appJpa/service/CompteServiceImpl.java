package tp.appJpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tp.appJpa.entity.Compte;
import tp.appJpa.entity.Operation;
import tp.appJpa.repository.RepositoryCompte;
import tp.appJpa.repository.RepositoryOperation;

@Transactional //ou equivalent EJB
@Service //ou bien @Stateless sur EJB
public class CompteServiceImpl implements CompteService {
	
	@Autowired //ou bien @Inject sur EJB
	private RepositoryCompte repositoryCompte;
	
	@Autowired //ou bien @Inject sur EJB
	private RepositoryOperation repositoryOperation;

	@Override
	public void effectuerVirement(double montant, long numCptDeb, long numCptCred) throws RuntimeException {

		Compte compteDeb = repositoryCompte.findById(numCptDeb);
		compteDeb.setSolde(compteDeb.getSolde()-montant);
		repositoryCompte.update(compteDeb);//quelquefois automatique si transaction
		Operation opDebit = new Operation(null,"debit suite virement",-montant); 
		opDebit.setCompte(compteDeb);
		repositoryOperation.insertNew(opDebit);
		
		Compte compteCred = repositoryCompte.findById(numCptCred);
		compteCred.setSolde(compteCred.getSolde()+montant);
		repositoryCompte.update(compteCred);//quelquefois automatique si transaction
		Operation opCredit = new Operation(null,"credit suite virement",+montant); 
		opCredit.setCompte(compteCred);
		repositoryOperation.insertNew(opCredit);
	}

}
