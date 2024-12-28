package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.ExamFormPower;
import zmdzzzMod.util.CardStats;

public class HavingMD extends BaseCard {
    public static final String ID = makeID(HavingMD.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            0
    );

//    private static final int DAMAGE = 1000;
//    private static final int UPG_DAMAGE = 3;
    private static final int MAGIC=20;
    private static final int UPG_MAGIC=-10;

    public HavingMD() {
        super(ID, info);
//        setCostUpgrade(2);
        setMagic(MAGIC,UPG_MAGIC);
//        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.

//        tags.add(CardTags.STARTER_STRIKE);
//        tags.add(CardTags.STRIKE);

        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.player.loseGold(MAGIC);
        addToBot(new GainEnergyAction(3));
    }
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        boolean canUse = true;
        if(AbstractDungeon.player.gold<MAGIC) {
            canUse = false;
        }
        return canUse;
   }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new HavingMD();
    }
}