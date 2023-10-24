package com.sistemablue.sistemablue.model.procedimentos;

import com.sistemablue.sistemablue.model.entities.Bensaude;
import com.sistemablue.sistemablue.model.entities.SaoFranciscoSaude;
import com.sistemablue.sistemablue.model.entities.Unimed;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TabelaProcedimentos {

    private Bensaude bensaude;
    private Unimed unimed;
    private SaoFranciscoSaude saoFranciscoSaude;


}
