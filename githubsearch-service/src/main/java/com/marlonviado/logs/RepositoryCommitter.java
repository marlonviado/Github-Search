package com.marlonviado.logs;

import java.util.HashSet;
import java.util.Set;

public class RepositoryCommitter {
	
	private TransferLog transferLog;
	
	public RepositoryCommitter() {}
	
	public RepositoryCommitter(TransferLog transferLog) {
		this.transferLog=transferLog;
	}
	
	public Set<String> removeDuplicate() {
		Set<String> set = new HashSet<>();
		for(int i=0; i<this.transferLog.logDTO().size(); i++) {
				
			set.add(this.transferLog.
					logDTO().
					get(i).
					getId() + " - " + 
					this.transferLog.
					logDTO().
					get(i).
					getName().
					substring(1, this.transferLog.logDTO().
							get(i).
							getName().
							length()-1) + " - " + 
							this.transferLog.
					logDTO().
					get(i).
					getCommits_url().
					substring(1,this.transferLog.logDTO().
							get(i).
							getCommits_url().
							length()-7)
					);
			
		}
		
		return set;

	}

}
