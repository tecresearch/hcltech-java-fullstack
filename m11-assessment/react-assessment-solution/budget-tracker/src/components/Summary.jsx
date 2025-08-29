import React from 'react'

const Summary = ({income,expense,balance}) => {
  return (
    <div>
      <h4>Summary</h4>
      <h5>Income: {income}</h5>
      <h5>Expense: {expense}</h5>
      <h5>Balance: {balance}</h5>
    </div>
  )
}

export default Summary
