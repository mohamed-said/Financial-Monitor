#!/usr/bin/python

import ystockquotes

companies_data_raw = open('companies.csv') #map_file
symbols_companies = [] # all companies with symbols read from csv file (map_array (strings)



########################indexing############################################
for line in companies_data_raw:
    symbols_companies.append(line)

symbol_indexed_Dictionary = dict()

#indexing (key -> symbol, value->company name)
for i in range(0, len(symbols_companies)):
    temp = symbols_companies[i].split(',')
    symbol_indexed_Dictionary[temp[0]] = temp[1]

#indexing done
##############################################################################

user_companies = open('final.out') #companies required
user_functions = open('final_funs.out') #functions reqiored

required_companies = [] # all companies required from executed file
required_functions = [] # all functions' numbers read from executed file


#companies splitted and ready
for line in user_companies:
    temp = line.split('|')
    required_companies += temp


#functions splitted and ready
for line in user_functions:
    temp = line.split('|')
    required_functions += temp
    
    
output_file = open('forecast.out', 'w')
                 
for c in required_companies:
    if (c == ''):
        break
    l = symbol_indexed_Dictionary.get(c)
    print(l + " ")
    output_file.write('\n' + l)    
    sym = c
    if '0' in required_functions:
        print("    Price: " + ystockquotes.get_price(sym))
        output_file.write("    Price: " + ystockquotes.get_price(sym) + '\n')
    
    if '1' in required_functions:
        print("    Change: " + ystockquotes.get_change(sym)) 
        output_file.write("    Change: " + ystockquotes.get_change(sym) + '\n')
    
    if '2' in required_functions:
        print("    Volume: " + ystockquotes.get_volume(sym))
        output_file.write("    Volume: " + ystockquotes.get_volume(sym) + '\n')
    
    if '3' in required_functions:
        print("    Daily Average Volume: " + ystockquotes.get_avg_daily_volume(sym))
        output_file.write("    Daily Average Volume: " + ystockquotes.get_avg_daily_volume(sym) + '\n')
    
    if '4' in required_functions:
        print("    Stock Exchange: " + ystockquotes.get_stock_exchange(sym))
        output_file.write("    Stock Exchange: " + ystockquotes.get_stock_exchange(sym) + '\n')
    if '5' in required_functions:
        print("    Market Cap: " + ystockquotes.get_market_cap(sym))
        output_file.write("    Market Cap: " + ystockquotes.get_market_cap(sym) + '\n')
    
    if '6' in required_functions:
        print("    Book Value: " + ystockquotes.get_book_value(sym))
        output_file.write("    Book Value: " + ystockquotes.get_book_value(sym) + '\n')
    
    if '7' in required_functions:
        print("    EBITDA: " + ystockquotes.get_ebitda(sym))
        output_file.write("    EBITDA: " + ystockquotes.get_ebitda(sym) + '\n')
    
    if '8' in required_functions:
        print("    Dividend Per Share: " + ystockquotes.get_dividend_per_share(sym))
        output_file.write("    Dividend Per Share: " + ystockquotes.get_dividend_per_share(sym) + '\n')
    
    if '9' in required_functions:
        print("    Dividend Yield: " + ystockquotes.get_dividend_yield(sym))
        output_file.write("    Dividend Yield: " + ystockquotes.get_dividend_yield(sym) + '\n')
    
    if '10' in required_functions:
        print("    Earnings Per Share: " + ystockquotes.get_earnings_per_share(sym))
        output_file.write("    Earnings Per Share: " + ystockquotes.get_earnings_per_share(sym) + '\n')
   
    if '11' in required_functions:
        print("    Fifty Two Week High: " + ystockquotes.get_52_week_high(sym))
        output_file.write("    Fifty Two Week High: " + ystockquotes.get_52_week_high(sym) + '\n')
    
    if '12' in required_functions:
        print("    Fifty Two Week Low: " + ystockquotes.get_52_week_low(sym))
        output_file.write("    Fifty Two Week Low: " + ystockquotes.get_52_week_low(sym) + '\n')
    
    if '13' in required_functions:
        print("    Fifty Day Moving Average: " + ystockquotes.get_50day_moving_avg(sym))
        output_file.write("    Fifty Day Moving Average: " + ystockquotes.get_50day_moving_avg(sym) + '\n')
    
    if '14' in required_functions:
        print("    200 Day Moving Average: " + ystockquotes.get_200day_moving_avg(sym))
        output_file.write("    200 Day Moving Average: " + ystockquotes.get_200day_moving_avg(sym) + '\n')
    
    if '15' in required_functions:
        print("    Price Earnings Ratio: " + ystockquotes.get_price_earnings_ratio(sym))
        output_file.write("    Price Earnings Ratio: " + ystockquotes.get_price_earnings_ratio(sym) + '\n')
    
    if '16' in required_functions:
        print("    Price Earnings Growth Ratio: " + ystockquotes.get_price_earnings_growth_ratio(sym))
        output_file.write("    Price Earnings Growth Ratio: " + ystockquotes.get_price_earnings_growth_ratio(sym) + '\n')
    
    if '17' in required_functions:
        print("    Price Book Ratio: " + ystockquotes.get_price_book_ratio(sym))
        output_file.write("    Price Book Ratio: " + ystockquotes.get_price_book_ratio(sym) + '\n')
    
    if '18' in required_functions:
        print("    Price Sales Ratio: " + ystockquotes.get_price_sales_ratio(sym))
        output_file.write("    Price Sales Ratio: " + ystockquotes.get_price_sales_ratio(sym) + '\n')
    
    if '19' in required_functions:
        print("    Short Ratio: " + ystockquotes.get_short_ratio(sym))
        output_file.write("    Short Ratio: " + ystockquotes.get_short_ratio(sym) + '\n')
    print("=================================\n")
    output_file.write("=================================\n")

output_file.close()

