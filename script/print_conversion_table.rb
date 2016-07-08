#!/usr/bin/env ruby

require 'mojinizer'

conversion_table = {}
conversion_table.merge!(Mojinizer::ROM_TO_KATA1)
conversion_table.merge!(Mojinizer::ROM_TO_KATA2)
conversion_table.merge!(Mojinizer::ROM_TO_KATA3)

conversion_table.each do |key, value|
  puts "ROMA_TO_KATA.put(\"#{key}\", \"#{value}\");"
end
