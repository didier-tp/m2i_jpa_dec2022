package tp.appliSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tp.appliSpring.entity.Compte;
import tp.appliSpring.repository.RepositoryCompte;

@Transactional //ou equivalent EJB
@Service //ou bien @Stateless sur EJB
public class CompteServiceImpl implements CompteService {
	
	@Autowired //ou bien @Inject sur EJB
	private RepositoryCompte repositoryCompte;

	@Override
	public void effectuerVirement(double montant, long numCptDeb, long numCptCred) throws RuntimeException {
		Compte compteDeb = repositoryCompte.findById(numCptDeb);
		compteDeb.setSolde(compteDeb.getSolde()-montant);
		repositoryCompte.update(compteDeb);//quelquefois automatique si transaction
		
		Compte compteCred = repositoryCompte.findById(numCptCred);
		compteCred.setSolde(compteCred.getSolde()+montant);
		repositoryCompte.update(compteCred);//quelquefois automatique si transaction
	}

}
