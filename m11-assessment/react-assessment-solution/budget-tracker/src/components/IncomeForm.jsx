import React, { useState } from 'react'

const IncomeForm = ({ income, setIncome }) => {
    const [localIncome, setLocalIncome] = useState(0);

    const addIncomeSubmit = (e) => {
        console.log(e.target);
        setIncome(Number(income)+Number(localIncome));
        setLocalIncome('');
    }

    return (
        <div>
            <h4>Income Form</h4>
            <input type="number"
                name="income"
                placeholder='enter your income'
                value={localIncome}
                onChange={(e) => setLocalIncome(e.target.value)}
            />
            <button onClick={addIncomeSubmit}>Add Income</button>

        </div>
    )
}

export default IncomeForm
